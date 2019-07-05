#!/usr/bin/env bash

#variavles
jmeterPath=/usr/local/Cellar/jmeter/5.1.1/bin/jmeter
csvResultFilePath=$PWD/src/test/java/com/example/scenarios/results.csv
jmxFilePath=$PWD/src/test/java/com/example/scenarios/DemoScenario.jmx
jmeterLogFile=$PWD/src/test/java/com/example/scenarios/jmeter.log

echo "==================Parameters========================="
echo "Path to the jmeter.sh file: "$jmeterPath
echo "Path to the *.jmx file with test: "$jmxFilePath
echo "Path to the *.csv file with results: "$csvResultFilePath
echo "Path to the *.log file with test logs: "$jmeterLogFile


echo "==================Running============================"
# -n -means non-gui mode
# -t -path to *.jmx file
# -g -path to the *c.sv result file
# Wide description
# -n This specifies JMeter is to run in non-gui mode
#-t [name of JMX file that contains the Test Plan].
#-l [name of JTL file to log sample results to].
#-j [name of JMeter run log file].
#-r Run the test in the servers specified by the JMeter property "remote_hosts"
#-R [list of remote servers] Run the test in the specified remote servers


# RUN JMETER WITHOUT REPORT
#sh $jmeterPath -n -t $jmxFilePath -l $csvResultFilePath -j $jmeterLogFile

# RUN JMETER WITH HTML REPORT (supported in jmeter 5.0)
sh $jmeterPath -n -t $jmxFilePath -l $csvResultFilePath -e -o $PWD/jmeter_report