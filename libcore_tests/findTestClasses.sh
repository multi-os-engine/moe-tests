filter=$1;
dp="../../../libcore"
all_test_files_str=$(find ${dp}/*/src/test -name "*Test.java" | \
  fgrep -v junit | \
  fgrep -v org/w3c/domts)
#echo $all_test_files_str
all_test_files_list=$(echo ${all_test_files_str} | tr ' ' "\n")
#echo $all_test_files_list
for file in ${all_test_files_list}; do
    is_abstract=$(echo ${file} | xargs grep -h 'abstract class');
    if [ ! -n "${is_abstract}" ]; then
        test_package=$(echo ${file} | xargs grep -h '^package ' | sed 's/^package //' | sed 's/;$//' | tr "\n" ".");
        test_class=$(echo ${file} | sed "s/.*\///" | sed "s/.java/.class,/");
        test_package_class=$test_package$test_class;
        if echo "$test_package_class" | grep -q "$filter"; then
            echo $test_package_class
        fi
    fi
done



