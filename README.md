## Requirements

Supported Jmeter versions: 5.0 - 5.2




### Run Jmeter using Taurus
``` 
pip install bzt

bzt src/test/java/com/example/scenarios/RandomScenarios.jmx 

## OR USING CONFIG

bzt jmeter-taurus/run-jmeter.yml

```




### Generate jmeter report (version 5.0 and higher)
Generation from an existing sample CSV log file
Use the following command:
``` 
jmeter -g <log file> -o <Path to output folder>

```
Generation after load test
Use the following command:
```

jmeter -n -t <test JMX file> -l <test log file> -e -o <Path to output folder>
```