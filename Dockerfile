FROM ubuntu
MAINTAINER AnkurD
CMD echo "Hello Docker"

RUN apt-get update && apt-get upgrade -y && apt-get install nodejs -y && apt-get install npm -y
RUN npm install protractor -g && npm install webdriver-manager -g
RUN apt-get install git -y

RUN apt-get install vim -y
RUN apt-get install chromium-browser -y

RUN mkdir /usr/e2e
RUN cd /usr/e2e
RUN npm install protractor
RUN webdriver-manager update
#RUN cp -r node_modules/protractor/node_modules/webdriver-manager/selenium /usr/e2e/lib/node_modules/protractor/webdriver-manager/