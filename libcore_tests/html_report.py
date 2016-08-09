from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
import smtplib
import os, shutil
import csv
import datetime, time
import argparse
import re

mail_server = 'moe.com'

def send_mail(sender, recipients, subject, text, text_type):
    for recipient in recipients:
        msg = MIMEMultipart('alternative')
        msg['Subject'] = subject
        msg['From'] = sender
        msg['To'] = recipient
        
        main_part = MIMEText(text, text_type)
        msg.attach(main_part)
        
        s = smtplib.SMTP(mail_server)
        s.sendmail(sender, recipient, msg.as_string())
        s.quit()

def process_path(path):
    if len(path) > 1:
        if path[-1:] == os.sep:
            return path
        else:
            return path + os.sep
    else:
        return ''

class Html_gen:
    def __init__(self, csv_path, html_path, send_mail_to):
        self.__success_status = "passed"
        self.__fail_status = "fail"
        self.__crash_status = "crash"
        self.__skip_status = "skipped"
        self.__csv_path = csv_path
        self.__html_path = html_path
        self.__send_mail_to = send_mail_to
	
    def __get_head_html(self, title):
        return """<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
                    <html lang="en">
                    <head>
                            <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
                            <title>""" + title + """</title>
                            <style type="text/css">
                                body { font: 11pt Calibri,Tahoma,Arial,sans-serif; }
                                table, td, th { font-size: 10pt; border-collapse: collapse; border: 1px solid #ccc; }
                                h2 { margin-bottom: .2em;}
                                table { margin-bottom: 1em;}
                                th { text-align: left;}
                                th { background-color: #eee;}
                                td, th { padding: .2em;}
                                td { vertical-align: top; }
                                small { font-size: 9pt; color: #999;}
                                del { background-color: #ffe6e6;}
                                ins { background-color: #e6ffe6;}
                                a { text-decoration: none; }
                                a:hover { text-decoration: underline; }
                                .eq100 { background-color: #bfb; }
                                .lt100 { background-color: #dfd; }
                                .lt80  { background-color: #ffd; }
                                .lt50  { background-color: #fdd; }
                                .not-implemented { background-color: #f7f7f7; color: #777;}
                                .m, .d { color: #777; font-size: 8pt;}
                                .info { border-bottom: 1px dotted #333; cursor: help; }
                                .errors { dotted #333; }
                                .cached { border-bottom: 1px dotted #999; cursor: help; }
                                .hung { font-weight: bold;}

                                a.expander { color: #bbb; font-size: 8pt; }
                                a.expander:hover { text-decoration: none; }
                                .child { display: none; }

                                .arr { font-size: 8pt; }
                                .bad { color: red; }
                                .good { color: green; }
                                .changed { cursor: help; color: #666; }
                            </style>
                    </head>"""
    
    def __get_color_status(self, status):
        if status == self.__success_status or status.startswith('100%'):
            return 'eq100'
        elif status == self.__skip_status:
            return 'lt80'
        elif status != self.__fail_status and status != self.__crash_status:
            if int(status.rsplit('%', 1)[0]) >= 80:
                return 'lt100'
            elif int(status.rsplit('%', 1)[0]) >= 50:
                return 'lt80'
            else:
                return 'lt50'
        else:
            return 'lt50'
    
    def __generate_html_table(self, header, csv_data, need_details=True):
        table = """
        <table width="100%" border="1" cellpadding="3px" id="test_table" class="order-table table">
        <thead>
            <tr>
        """
        for header_cell in header:
            table += '<th>{cell}</th>'.format(cell = header_cell)
        table += '''
            </tr>
        </thead>
        <tbody>'''
        for csv_row in csv_data:
            table += '''
            <tr>
            '''
            status = self.__get_color_status(csv_row[1])
            for i in range(len(csv_row)):
                if i == len(csv_row) - 1 and need_details == True:
                    url = csv_row[i]
                    url = re.sub("\^", "", url)
                    table += '''
                    <td class="{status}">
                    <a href="{url}" target="_blank">Details</a>
                    </td>
                    '''.format(status = status, url = url)
                else:
                    cell = csv_row[i]
                    if i == len(csv_row) - 1 and any(csv_row[1]==i for i in ['fail', 'crash']):
                        url = re.sub("\^", "", cell)
                        table += '''
                        <td class="{status}">
                        <a href="{url}" target="_blank">Details</a>
                        </td>
                        '''.format(status = status, url = url)
                    else:
                        table += '''
                        <td class="{status}">
                        {cell}
                        </td>
                        '''.format(status = status, cell = cell)
            table += '''
            </tr>
            '''

        table +="""</tbody>
        </table>"""
        return table
    
    def __internal_report_generation(self, report_path, title, content):
        table_header = ['Class name', 'Status', 'Link']
        html_page = self.__get_head_html(title)
        html_page += """
        <body>
            <h1>{title_str}</h1>
            <br>
            """.format(title_str=title)
		
        html_page += self.__generate_html_table(table_header, content, False)
		
        html_page += """
            </body>
        </html>"""
		
        with open(report_path + 'index.html', 'wt', encoding='utf-8') as f:
            f.write(html_page)
    
    def __get_package_name(self, file_name):
        package_name = ''
        for i in range(len(file_name)):
            if i == 0:
                package_name += chr(ord(file_name[i])+32)
            elif (ord(file_name[i]) >= 97 and ord(file_name[i]) <= 122) or (ord(file_name[i]) >= 48 and ord(file_name[i]) <= 57):
                package_name += file_name[i]
            else:
                package_name += '.' + chr(ord(file_name[i])+32)
        return package_name

    def __create_log_file(self, input_log_file, path_to_output_file, output_file_name):
        output_log_file = process_path(path_to_output_file) + output_file_name +'.txt'
        write_to_file = False
        with open(input_log_file, 'rt', encoding='utf-8') as input:
            for line in input:
                if output_file_name in line and 'TESTE' in line:
                    write_to_file = False
                elif write_to_file == True:
                    with open(output_log_file, 'at', encoding='utf-8') as output:
                        output.write(line)
                elif output_file_name in line and 'TESTS' in line:
                    write_to_file = True
    
    def report_generation(self):
        # Get data for html
        csv_data = []
        table_header = ['Test name', 'Status (passed/skipped/total)', 'Link']

        self.__html_path = process_path(self.__html_path)
        if os.path.exists(self.__html_path):
            shutil.rmtree(self.__html_path)
            time.sleep(1)
        os.mkdir(self.__html_path)
        self.__csv_path = process_path(self.__csv_path)
        num_classes = 0
        num_passed_classes = 0
        platform = ''
        for file_name in os.listdir(self.__csv_path):
            test_info = []
            if file_name.endswith('.csv') and not file_name.startswith('summary'):
                package_name = self.__get_package_name(file_name[:-4])
                test_info.append(package_name)
                html_page_test = process_path(self.__html_path + package_name)
                os.mkdir(html_page_test)
                page_path = self.__html_path[self.__html_path.rfind('HTML Reports') + len('HTML Reports') + 1:]
                platform = page_path if page_path[-1] != os.sep else page_path[:-len(os.sep)]
                platform = platform[platform.rfind('/') + 1:]
                link = 'http://moe.com/HTML%20Reports/' + page_path + package_name
                
                file_content = []
                num_passed = 0
                num_skipped = 0
                last_test_name = ''
                with open(self.__csv_path + file_name) as csvfile:
                    reader = csv.reader(csvfile)
                    for row in reader:
                        if len(row) == 2:
                            if last_test_name == row[0]:
                                break
                            else:
                                last_test_name = row[0]
                            num_classes = num_classes+1
                            if row[1] == 'FAILED':
                                row[1] = 'fail'
                                input_log_file = self.__csv_path + file_name[:-4] + '_log.txt'
                                self.__create_log_file(input_log_file, html_page_test, row[0])
                                row.append(process_path(link) + row[0] +'.txt')
                            elif row[1] == 'SKIPPED':
                                row[1] = 'skipped'
                                num_skipped = num_skipped+1
                                row.append('')
                            elif row[1] == 'CRASH':
                                row[1] = 'crash'
                                input_log_file = self.__csv_path + file_name[:-4] + '_log.txt'
                                self.__create_log_file(input_log_file, html_page_test, row[0])
                                row.append(process_path(link) + row[0] +'.txt')
                            else:
                                row[1] = 'passed'
                                num_passed_classes = num_passed_classes+1
                                num_passed = num_passed+1
                                row.append('')
                            file_content.append(row)
                self.__internal_report_generation(html_page_test, package_name, file_content)
                
                if len(file_content) != 0:
                    per = str(int(num_passed*100/len(file_content)))
                else:
                    per = '0'
                test_info.append(per + '% (' + str(num_passed) + '/' + str(num_skipped) + '/' + str(len(file_content)) + ')')
                test_info.append(process_path(link) + 'index.html')
                csv_data.append(test_info)
        
        # Gen html
        status = self.__success_status
        title = 'libcore_tests on ' + platform
        link = title + '/index.html'
		
        if num_classes != 0:
            per = str(int(num_passed_classes*100/num_classes))
        else:
            per = '0'
        html_page = self.__get_head_html(title)
        html_page += """
        <body>
            <h1>{title_str}</h1>
            <big><b>Total: </b>{per}% ({num_passed}/{num_classes})<br></big>
            """.format(title_str=title, per=per, num_passed=str(num_passed_classes), num_classes=str(num_classes))
		
        html_page += self.__generate_html_table(table_header, csv_data)
		
        html_page += """
            </body>
        </html>"""
		
        for row in csv_data:
            if row[1] == self.__fail_status:
                status = self.__fail_status
                break
        with open(self.__html_path + 'index.html', 'wt', encoding='utf-8') as f:
            f.write(html_page)
        return [title, status, link]

    def send_email_notification(self):
        if self.__send_mail_to is None:
            return
        with open(self.__html_path + 'index.html', 'rt', encoding='utf-8') as f:
            text = f.read()
        subject = self.__html_path if self.__html_path[-1] != os.sep else self.__html_path[:-len(os.sep)]
        platform = subject[subject.rfind('/') + 1:]
        subject = subject[:-(len(platform)+1)]
        build_num = subject[subject.rfind('/') + 1:]
        subject = 'Summary report (' + platform + ') - ' + build_num
        send_mail('lab@moe.com', self.__send_mail_to, subject, text, 'html')

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('--csv_dir', dest='csv_dir', action='store', required = True, help='Directory with csv-files')
    parser.add_argument('--html_dir', dest='html_dir', action='store', required = True, help='Report directory')
    parser.add_argument('--send_mail_to', dest='send_mail_to', nargs='*', help='List of e-mails')
    args = parser.parse_args()
    html_gen = Html_gen(args.csv_dir, args.html_dir, args.send_mail_to)
    html_gen.report_generation()
    html_gen.send_email_notification()
    print('Done!')
