FROM node:12.2.0-alpine 

ENV BUILD_PATH /usr/src/app 
WORKDIR /app 

COPY package.json /app/package.json 

RUN npm install --global express && npm link express && \ 
npm install --global express-session && npm link express-session 
RUN npm install 

COPY . /app 

RUN npm rebuild node-sass && npm run build 

CMD [ "node", "--inspect=5858", "./server.js" ] 
EXPOSE 9000