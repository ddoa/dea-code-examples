soapui_download="/home/vagrant/Downloads/soapui-install.sh"
if [ ! -f "$soapui_download" ]
then
  wget -O /home/vagrant/Downloads/soapui-install.sh "http://downloads.sourceforge.net/project/soapui/soapui/5.0.0/SoapUI-x64-5.0.0.sh?r=&ts=1404482308&use_mirror=kent"
  chmod +x /home/vagrant/Downloads/soapui-install.sh
  cd /home/vagrant/Applications
  /home/vagrant/Downloads/soapui-install.sh -q
fi
  
