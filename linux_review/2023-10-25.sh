
cd
pwd
ls
ls -l
cd
cd ~
mkdir linktest
cd linktest/
ls
nano basefile
ls
ls -l
ln basefile hardlink
ls -l
cat basefile 
cat hardlink 
ln -s basefile softlink
ls -l
cat softlink
ls -il
ls
ls -l
mv basefile ../
pwd
ls -l /root
ls -l
cat softlink
cat hardlink 
ls -il
mv ../basefile .
ls
ls -il
cat softlink 
dpkg -l zip
dpkg -L zip
cd
ls
cd 다운로드/
ls
dpkg -l axel
dpkg --info axel_2.17.5-1ubuntu1_amd64.deb 
dpkg -i axel_2.17.5-1ubuntu1_amd64.deb 
axel --help
man axel
axel
axel https://cdn.kernel.org/pub/linux/kernel/v5.x/linux-5.10.198.tar.xz
ls -l
dpkg -l axel_2.17.5-1ubuntu1_amd64.deb 
dpkg -l axel
dpkg -r axel
axel
ls
ls -l
dpkg -l galculator
dpkg -i galculator_2.1.4-1build1_amd64.deb 
apt
apt-get
dpkg -i galculator
dpkg -l galculator
dpkg -r galculator
dpkg -l galculator
apt-cache show galculator
apt-cache depends galculator
apt install galculator
galculator 
cd /etc/apt
ls
gedit sources.list
less sources.list
nano sources.list
apt update
apt install galculator
apt remove galculator
apt autoremove
apt purge galculator
apt install galculator
nano sources.list
FG
fg
gedit sources.list
apt install galculator
apt update
gedit sources.list
apt update
gedit sources.list
apt update
gedit sources.list
apt update
apt install galculator
galculator 
nano sources.list
apt upgrade
apt update
apt upgrade
cd
cd ~
mkdir zip-ex
cd zip-ex/
nano test1.txt
ls -l
nano test1.txt
ls -l
xz test1.txt 
ls -l
xz -d test1.txt 
xz -d test1.txt.xz 
ls -l
xz -k test1.txt 
ls -l
bzip2 test1.txt
ls -l
bzip2 -d test1.txt
bzip2 -d test1.txt.bz2 
ls -l
bzip2 -k test1.txt
ls -l
gzip test1.txt
ls -l
gzip -d test1.txt.gz
ls -l
gzip -k test1.txt
ls -l
zip zipped.zip test1.txt
ls -l
unzip zipped.zip 
ls -l
unzip zipped.zip 
ls -l
tar cf test1.txt test2.txt 
ls -l
tar cf tartar.tar test1.txt test2.txt 
ls -l
tar cvf tartar2.tar test1.txt test2.txt 
ls -l
tart cvfz test1.txt test2.txt 
tar cvfz mytar.tar.gz test1.txt test2.txt 
ls -l
tar xf tartar.tar 
ls -l
tar xvf tartar.tar 
ls -l
rm test1.txt test2.txt 
ls -l
tar xvf tartar.tar
ls -l
tar xvfz mytar.tar.gz 
ls -l
rm test1.txt test2.txt 
ls -l
tar xvfz mytar.tar.gz 
ls -l
tar cvfj system.tar.xz /etc/systemd/
ls -l
tar xfj system.tar.xz
ls
ls etc
ls etc/systemd/
tar Cxfj newdir system.tar.xz 
ls
mkdir newdir
tar Cxfj newdir system.tar.xz 
ls newdir/
ls
find -name "test*"
find /etc -name "*.conf"
cd ~
ls
ls -l
find -user root
find -user ubuntu
find /home -user ubuntu
find ~ -perm 644
ls -l
find ~ -perm 755
find -size +10k
find -size +10024k
find -size +10000k
find -size -1k
history
find -name "t*"
find -size +10000k
which
which gzip
cd /usr/bin/gzip
cd /usr/bin/
ls gzip
ls -l gzip
which bzip2
whereis gzip
gedit /etc/crontab
nano /etc/crontab
systemctl status cron
nano /etc/crontab
pwd
cd
pwd
touch myBackup.sh
ls -l myBackup.sh 
chmod 755 myBackup.sh 
ls -l myBackup.sh 
nano myBackup.sh 
ls /backup
mkdir /backup
ls myBackup.sh 
./myBackup.sh 
ls /backup/
systemctl restart cron
timedatectl set-ntp 0
date 011503002023
ls /backup
date 021503002023
ls /backup
at
apt -y install at rdate
rdate
at
rdate -s time.bora.net
at
at 4:00 am tomorrow
at -l
atrm 1
at -l
gedit myBackup.sh 