This Vagrantfile is used to install and provision a VirtualBox image with the following specs:
- Ubuntu 12.4 LTS
- Ubuntu Desktop
- LAMP 
- Java 7
- NetBeans 8 including Glassfish 4
- Springsource Toolsuite (STS) 2.9.1 including Maven 3.0.3 and Roo 1.2.1
- SOAPUI 5

PREREQUISITES
* Install VirtualBox 4.3.10 or higher
* Install Vagrant 1.4.1 or higher

To install the image:
- Run: vagrant up and wait for the script to stop (somewhere 'round STS). The image is started in terminal mode.
- Run: vagrant reload (or vagrant up).
The image has an alternative boot-setup. Select the first option, the image is now started in UI-mode

Eventually, after appr. 20 minutes the image is completely provisioned. The image can be used with the credentials vagrant/vagrant. When the performance of the image is poor, consider increasing the available memory in Vagrantfile. 
