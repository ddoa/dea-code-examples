netbeans_download="/home/vagrant/Downloads/netbeans-installer.sh"
if [ ! -f "$netbeans_download" ]
then
  wget -O /home/vagrant/Downloads/netbeans-installer.sh http://download.netbeans.org/netbeans/8.0/final/bundles/netbeans-8.0-javaee-linux.sh
  chmod +x /home/vagrant/Downloads/netbeans-installer.sh
  cd /home/vagrant/Applications
  /home/vagrant/Downloads/netbeans-installer.sh --silent "-J-Dnb-base.installation.location=/home/vagrant/Applications/netbeans-8.0"
fi

