#!/bin/sh

CWD=$(pwd)
LOGS=$CWD/logs
cd ../../../moe/moe-java-tools/bin

groups="
    JunitExtAndroidDatabase;
    JunitExtJavaAwtFont;
    JunitExtJavaBeans;
    JunitExtJavaIo;
    JunitExtJavaLang;
    JunitExtJavaLangAnnotation;
    JunitExtJavaLangRef;
    JunitExtJavaLangReflect;
    JunitExtJavaMath;
    JunitExtJavaNet;
    JunitExtJavaNio;
    JunitExtJavaNioChannels;
    JunitExtJavaNioChannelsSpi;
    JunitExtJavaNioCharset;
    JunitExtJavaSecurity;
    JunitExtJavaSecurityAcl;
    JunitExtJavaSecurityCert;
    JunitExtJavaSecurityInterfaces;
    JunitExtJavaSecuritySpec;
    JunitExtJavaSql;
    JunitExtJavaText;
    JunitExtJavaUtil;
    JunitExtJavaUtilConcurrent;
    JunitExtJavaUtilConcurrentAtomic;
    JunitExtJavaUtilConcurrentLocks;
    JunitExtJavaUtilJar;
    JunitExtJavaUtilLogging;
    JunitExtJavaUtilPrefs;
    JunitExtJavaUtilRegex;
    JunitExtJavaUtilZip;
    JunitExtJavaxCrypto;
    JunitExtJavaxCryptoInterfaces;
    JunitExtJavaxCryptoSpec;
    JunitExtJavaxNet;
    JunitExtJavaxNetSsl;
    JunitExtJavaxSecurityAuth;
    JunitExtJavaxSecurityAuthCallback;
    JunitExtJavaxSecurityAuthLogin;
    JunitExtJavaxSecurityAuthX500;
    JunitExtJavaxSecurityCert;
    JunitExtJavaxSql;
    JunitExtJavaxXmlParsers;
    JunitExtOrgApacheHarmonySecurity;
    JunitExtOrgXmlSax;
    JunitExtOrgXmlSaxExt;
    JunitExtOrgXmlSaxHelpers;
    JunitIntComAndroidDex;
    JunitIntComAndroidOrgBouncycastle;
    JunitIntDalvikSystem;
    JunitIntLibcore;
    JunitIntLibcoreIcu;
    JunitIntLibcoreIo;
    JunitIntLibcoreNet;
    JunitIntLibcoreReflect;
    JunitIntLibcoreUtil;
    JunitIntLibcoreXml;"

    #JunitComAndroidOkhttp;
    #JunitComAndroidOkio;
    #JunitComAndroidOrgConscrypt;
    #JunitJavaNioCharsetSpi;
    #JunitJavaxMicroeditionKhronosEgl;
    #JunitJavaxMicroeditionKhronosOpengles;
    #JunitOrgApacheHarmonyXml;
    #JunitOrgApacheHttp;
    #JunitOrgApacheHttpAuth;
    #JunitOrgApacheHttpClient;
    #JunitOrgApacheHttpClientMethods;
    #JunitOrgApacheHttpClientParams;
    #JunitOrgApacheHttpClientProtocol;
    #JunitOrgApacheHttpClientUtils;
    #JunitOrgApacheHttpConn;
    #JunitOrgApacheHttpConnParams;
    #JunitOrgApacheHttpConnRouting;
    #JunitOrgApacheHttpConnScheme;
    #JunitOrgApacheHttpConnSsl;
    #JunitOrgApacheHttpConnUtil;
    #JunitOrgApacheHttpCookie;
    #JunitOrgApacheHttpEntity;
    #JunitOrgApacheHttpImpl;
    #JunitOrgApacheHttpImplAuth;
    #JunitOrgApacheHttpImplClient;
    #JunitOrgApacheHttpImplConn;
    #JunitOrgApacheHttpImplConnTsccm;
    #JunitOrgApacheHttpImplCookie;
    #JunitOrgApacheHttpImplEntity;
    #JunitOrgApacheHttpImplIo;
    #JunitOrgApacheHttpIo;
    #JunitOrgApacheHttpMessage;
    #JunitOrgApacheHttpParams;
    #JunitOrgApacheHttpProtocol;
    #JunitOrgApacheHttpUtil;
    #JunitOrgXmlpull;

rm -rf $LOGS
mkdir $LOGS
timeout=1200
device=$1
dev_type=$2

if [ ! -z "$3" ]; then
    timeout=$3
fi

echo "run on $device... "

if [ $device == "sim" ]; then
    if [ -e /tmp/summaryExt.csv ]; then
        rm /tmp/summaryExt.csv
    fi
    if [ -e /tmp/summaryInt.csv ]; then
       rm /tmp/summaryInt.csv
    fi
else
    echo "timeout = $timeout sec"
fi

VAR=( $groups )
NGROUPS=${#VAR[@]}
TEST=1
for g in $(echo $groups | tr ";" "\n"); do
    echo "Test #"$TEST "/" $NGROUPS " : " $g
    TEST=$((TEST+1))
    g_short=${g#"JunitExt"}
    g_short=${g_short#"JunitInt"}
	BUILD_MODE=Debug
    if [ $device == "device" ]; then
	    if [ -d "$CWD/build/moe/xcodebuild/sym/Release-iphoneos" ]; then
		    BUILD_MODE=Release
        fi
        python timeout_libcore.py "$LOGS/${g_short}_log.txt" "$CWD/build/moe/xcodebuild/sym/$BUILD_MODE-iphoneos/libcore_tests-Test.app" "-args ${g}" $dev_type $timeout
        rm -rf $CWD/tmpDev
        mkdir -p $CWD/tmpDev
        ./ios-deploy/ios-deploy -r -w -1 com.intel.libcore-tests-Test -2 $CWD/tmpDev --id $dev_type
        cp $CWD/tmpDev/Documents/tmp/${g_short}.csv $LOGS
        if [ -e $CWD/tmpDev/Documents/tmp/summaryExt.csv ]; then
            cat $CWD/tmpDev/Documents/tmp/summaryExt.csv >> $LOGS/summaryExt.csv
        fi
        if [ -e $CWD/tmpDev/Documents/tmp/summaryInt.csv ]; then
            cat $CWD/tmpDev/Documents/tmp/summaryInt.csv >> $LOGS/summaryInt.csv
        fi
        start_here=$(echo ${LOGS}/${g_short}.csv | xargs grep -h -m 1 "NOTRUN" | sed 's/-/#/' | sed 's/,NOTRUN//');
        while [ -n "${start_here}" ]; do
            python timeout_libcore.py "$LOGS/${g_short}_log.txt_" "$CWD/build/moe/xcodebuild/sym/$BUILD_MODE-iphoneos/libcore_tests-Test.app" "-args -start ${start_here} ${g}" $dev_type $timeout
            cat "$LOGS/${g_short}_log.txt_" >> $LOGS/${g_short}_log.txt
            rm -rf $LOGS/${g_short}_log.txt_
            rm -rf $CWD/tmpDev
            mkdir -p $CWD/tmpDev
            ./ios-deploy/ios-deploy -r -w -1 com.intel.libcore-tests-Test -2 $CWD/tmpDev --id $dev_type
            cp $LOGS/${g_short}.csv $LOGS/${g_short}.csv_ 
            cat "$LOGS/${g_short}.csv_" | grep -v "NOTRUN" > $LOGS/${g_short}.csv
            cat "$CWD/tmpDev/Documents/tmp/${g_short}.csv" >> $LOGS/${g_short}.csv 
            rm -rf $LOGS/${g_short}.csv_
            start_here=$(echo ${LOGS}/${g_short}.csv | xargs grep -h -m 1 "NOTRUN" | sed 's/-/#/' | sed 's/,NOTRUN//');
        done 
    else
	    if [ -d "$CWD/build/moe/xcodebuild/sym/Release-iphonesimulator" ]; then
            BUILD_MODE=Release
        fi
        if [ -e /tmp/${g_short}.csv ]; then
            rm /tmp/${g_short}.csv
        fi
	( ./ios-sim/ios-sim launch "$CWD/build/moe/xcodebuild/sym/$BUILD_MODE-iphonesimulator/libcore_tests-Test.app" --devicetypeid $dev_type --stderr "$LOGS/${g_short}_log.txt" --stdout "$LOGS/${g_short}_log.txt" --args -args ${g} ) & pid=$!
        for i in {1..360}
	do
		if kill -s 0 $pid; then
			sleep 5
			if [ $i == 360 ]; then
				osascript -e 'quit app "Simulator"'
			fi
		else
			break
		fi
	done
	wait $pid
	cp /tmp/${g_short}.csv $LOGS
        if [ -e /tmp/summaryExt.csv ]; then
            cp /tmp/summaryExt.csv $LOGS
        fi
        if [ -e /tmp/summaryInt.csv ]; then
            cp /tmp/summaryInt.csv $LOGS
        fi

    start_here=$(echo ${LOGS}/${g_short}.csv | xargs grep -h -m 1 "NOTRUN" | sed 's/-/#/' | sed 's/,NOTRUN//');
    while [ -n "${start_here}" ]; do
        ( ./ios-sim/ios-sim launch "$CWD/build/moe/xcodebuild/sym/$BUILD_MODE-iphonesimulator/libcore_tests-Test.app" --devicetypeid $dev_type --stderr "$LOGS/${g_short}_log.txt" --stdout "$LOGS/${g_short}_log.txt" --args -args -start ${start_here} ${g} ) & pid=$!
        for i in {1..360}
    do
        if kill -s 0 $pid; then
            sleep 5
            if [ $i == 360 ]; then
                osascript -e 'quit app "Simulator"'
            fi
        else
            break
        fi
    done
    wait $pid
    cp $LOGS/${g_short}.csv $LOGS/${g_short}.csv_ 
    cat "$LOGS/${g_short}.csv_" | grep -v "NOTRUN" > $LOGS/${g_short}.csv
    cat "/tmp/${g_short}.csv" >> $LOGS/${g_short}.csv 
    rm -rf $LOGS/${g_short}.csv_
    start_here=$(echo ${LOGS}/${g_short}.csv | xargs grep -h -m 1 "NOTRUN" | sed 's/-/#/' | sed 's/,NOTRUN//');
    done   
fi
done

