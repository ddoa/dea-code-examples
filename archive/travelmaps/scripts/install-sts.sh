sts_download="/home/vagrant/Downloads/springsource-tool-suite-2.9.1.RELEASE-e3.7.2-linux-gtk-x86_64.tar.gz"
if [ ! -f "$sts_download" ]
then
  wget -O /home/vagrant/Downloads/springsource-tool-suite-2.9.1.RELEASE-e3.7.2-linux-gtk-x86_64.tar.gz http://download.springsource.com/release/STS/2.9.1/dist/e3.7/springsource-tool-suite-2.9.1.RELEASE-e3.7.2-linux-gtk-x86_64.tar.gz 
  mkdir /home/vagrant/Applications
  cd /home/vagrant/Applications
  tar xvzf /home/vagrant/Downloads/springsource-tool-suite-2.9.1.RELEASE-e3.7.2-linux-gtk-x86_64.tar.gz
fi

