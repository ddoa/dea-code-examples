sudo debconf-set-selections <<< 'mysql-server mysql-server/root_password password vagrant'
sudo debconf-set-selections <<< 'mysql-server mysql-server/root_password_again password vagrant'
sudo debconf-set-selections <<< 'debconf shared/accepted-oracle-license-v1-1 select true'
sudo debconf-set-selections <<< 'debconf shared/accepted-oracle-license-v1-1 seen true'
sudo debconf-set-selections <<< 'phpmyadmin phpmyadmin/dbconfig-install boolean true'
sudo debconf-set-selections <<< 'phpmyadmin phpmyadmin/app-password-confirm password vagrant'
sudo debconf-set-selections <<< 'phpmyadmin phpmyadmin/mysql/admin-pass password vagrant'
sudo debconf-set-selections <<< 'phpmyadmin phpmyadmin/mysql/app-pass password vagrant'
sudo debconf-set-selections <<< 'phpmyadmin phpmyadmin/reconfigure-webserver multiselect apache2'
sudo apt-get -y install mysql-server
sudo apt-get -q -y install phpmyadmin
sudo apt-get -q -y install oracle-java7-installer
