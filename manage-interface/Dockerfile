# Use the official Node.js image as the base image
FROM node:18

# Set the working directory inside the container
WORKDIR /usr/src/app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install Angular CLI globally
RUN npm install -g @angular/cli

# Install project dependencies
RUN npm install

# Copy the entire application to the working directory
COPY . /usr/src/app

# Expose the port on which the app will run
EXPOSE 4200

# Command to start the Angular app
CMD ["ng", "serve", "--host", "0.0.0.0", "--port", "4200"]