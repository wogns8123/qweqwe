FROM node:16.15.0 as build-stage
<<<<<<< HEAD
RUN npm install -g http-server
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
WORKDIR /var/jenkins_home/workspace/deploytest/frontend
COPY package*.json ./
RUN npm install
COPY . .
<<<<<<< HEAD
RUN npm run build
EXPOSE 8180
CMD [ "http-server","-p","8180", "dist" ]

=======
RUN npm install --save-dev @babel/preset-env
RUN npm run build
FROM nginx:stable-alpine as production-stage

COPY --from=build-stage /var/jenkins_home/workspace/deploytest/frontend/dist /usr/share/nginx/html
#COPY --from=build-stage /var/jenkins_home/workspace/deploytest/frontend/deploy_conf/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 3000
CMD ["nginx", "-g","daemon off;"]
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
