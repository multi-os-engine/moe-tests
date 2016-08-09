if [ $# -gt 0 ]; then
    targetID=$1
    if [[ $targetID == *"-"* ]]; then
        outputfile=./build/moe/reports/junit-iphonesimulator/$targetID.output.txt
    else
        outputfile=./build/moe/reports/junit-iphoneos/$targetID.output.txt
    fi
else
    targetID="5EF11B28-928E-4807-8B9F-BF72A1882826"
    outputfile=./build/moe/reports/junit-iphonesimulator/$targetID.output.txt
fi

#number of executed, failed and ignored tests
exec_tests=$(grep "%TESTS" $outputfile | wc -l)
failed_tests=$(grep "%FAILED" $outputfile |wc -l)
ignored_tests=$(grep "%IGNORED" $outputfile | wc -l)

#create a csv-file with tests' names and results
separator=","
succeeded_text="SUCCEEDED"
failed_text="FAILED"
ignored_text="IGNORED"
notstarted_text="NOT\ STARTED"
 
failedSubst=$(grep -o "%FAILED.*)" $outputfile | sed -e 's|.*:\([^(]*\)(\([^)]*\)).*|s/\2-\1'$separator"$succeeded_text"'/\2-\1'$separator$failed_text'/g|g')
ignoredSubst=$(grep -o "%IGNORED.*" $outputfile | sed -e 's|.*:\(.*\)|s/\1'$separator"$notstarted_text"'/\1'$separator$ignored_text'/g|g')
all=$(grep -o "%TESTD.*" $outputfile | sed -e 's|.*:\(.*\)|\1'$separator"$notstarted_text"'|g')
startedSubst=$(grep -o "%TESTE.*" $outputfile | sed -e 's|.*:\(.*\)|s/\1'$separator"$notstarted_text"'/\1'$separator$succeeded_text'/g|g')

printf "$all\n" > result_$targetID.csv
sed -i '' -f <( printf "$startedSubst\n" ) result_$targetID.csv
sed -i '' -f <( printf "$failedSubst\n$ignoredSubst\n" ) result_$targetID.csv

#output results
if ! [ $failed_tests == 0 ]; then
    printf "$((failed_tests))/$((exec_tests)) tests failed, $((ignored_tests)) tests and classes were ignored\n"
    cat result_$targetID.csv
else
    printf "$((exec_tests)) tests succeded, $((ignored_tests)) tests and classes were ignored\n"
fi
