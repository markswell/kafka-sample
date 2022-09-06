#!/bin/bash
mvn clean package -DskipTests
WILDFLY_PATH=/opt/wildfly-26.1.1.Final
rm $WILDFLY_PATH/standalone/deployments/$ARTIFACT*
$WILDFLY_PATH/bin/standalone.sh &
ARTIFACT=$(ls target/*.war | sed "s/target\///g")
cp target/$ARTIFACT $WILDFLY_PATH/standalone/deployments/
$WILDFLY_PATH/bin/jboss-cli.sh -c --controller=127.0.0.1:9990 --command="deploy --force $WILDFLY_PATH/standalone/deployments/$ARTIFACT"
echo "Deploy it's done: $ARTIFACT"
