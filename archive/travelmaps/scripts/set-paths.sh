sudo touch /etc/profile.d/set-path.sh
sudo -H -u root bash -c 'echo "export PATH=$PATH:/home/vagrant/Applications/springsource/spring-roo-1.2.1.RELEASE/bin:/home/vagrant/Applications/springsource/apache-maven-3.0.3/bin:/home/vagrant/SmartBear/SoapUI-5.0.0/bin:/home/vagrant/netbeans-8.0/bin" > /etc/profile.d/set-path.sh'
