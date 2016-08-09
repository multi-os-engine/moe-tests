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
    def __init__(self, html_path, send_mail_to):
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
        if status.startswith('100%'):
            return 'eq100'
        elif int(status.rsplit('%', 1)[0]) >= 80:
            return 'lt100'
        elif int(status.rsplit('%', 1)[0]) >= 50:
            return 'lt80'
        else:
            return 'lt50'
    
    def __generate_html_table(self, header, data):
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
        for row in data:
            table += '''
            <tr>
            '''
            status = self.__get_color_status(row[1])
            for i in range(len(row)):
                if i == len(row) - 1:
                    url = row[i]
                    url = re.sub("\^", "", url)
                    table += '''
                    <td class="{status}">
                    <a href="{url}" target="_blank">Details</a>
                    </td>
                    '''.format(status = status, url = url)
                else:
                    cell = row[i]
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
    
    def __get_status(self, html_file):
        with open(html_file, 'rt', encoding='utf-8') as f:
            for line in f:
                if 'Total:' in line:
                    return line[line.rfind('</b>') + len('</b>') + 0:line.rfind('<br>')]
    
    
    def report_generation(self):
        # Get data for html
        data = []
        table_header = ['Platform name', 'Status (passed/total)', 'Link']

        self.__html_path = process_path(self.__html_path)
        for file_name in os.listdir(self.__html_path):
            if os.path.isdir(self.__html_path + file_name) and os.path.exists(self.__html_path + file_name + '/index.html'):
                test_info = []
                test_info.append(file_name)
                status = self.__get_status(self.__html_path + file_name + '/index.html')
                test_info.append(status)
                page_path = self.__html_path[self.__html_path.rfind('HTML Reports') + len('HTML Reports') + 1:]
                link = 'http://moe.com/HTML%20Reports/' + page_path + '/' + file_name + '/index.html'
                test_info.append(link)
                data.append(test_info)
        
        # Gen html
        title = 'libcore_tests'
        #Get current time and date
        now_date = datetime.datetime.now()
        date_str = now_date.strftime("%Y %B %d")
        time_str = now_date.strftime("%H:%M:%S")
		
        html_page = self.__get_head_html(title)
        html_page += """
        <body>
            <h1>{title_str}</h1>
            <small>Generated on {date_str} {time_str}</small>
            """.format(title_str=title, time_str=time_str, date_str=date_str)
		
        html_page += self.__generate_html_table(table_header, data)
		
        html_page += """
            </body>
        </html>"""
		
        with open(self.__html_path + 'index.html', 'wt', encoding='utf-8') as f:
            f.write(html_page)
        return [title]

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
    parser.add_argument('--res_dir', dest='res_dir', action='store', required = True, help='Report directory')
    parser.add_argument('--send_mail_to', dest='send_mail_to', nargs='*', help='List of e-mails')
    args = parser.parse_args()
    html_gen = Html_gen(args.res_dir, args.send_mail_to)
    html_gen.report_generation()
    html_gen.send_email_notification()
    print('Done!')
