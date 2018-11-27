import { Component, OnInit } from '@angular/core';
import { Users } from '../Users';
import { UsersService } from '../user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-upload-user',
  templateUrl: './upload-user.component.html',
  styleUrls: ['./upload-user.component.scss']
})
export class UploadUserComponent implements OnInit {

  filename: any;
  link: any;
  ext: string;
  extCheck: boolean = false;
  extation: string = ".csv";
  userDetails: Users = new Users();
  userDetail: Users = new Users();
  lines = [];
  ipAddress: any;
  constructor(private userservice: UsersService, public router: Router) { }

  fileChangeListener(event: any) {
    this.filename  =  event.target.files[0].name;
    this.link  =  event.target.files[0];
    this.ext  =  this.filename.substring(this.filename.lastIndexOf('.')).toLowerCase();

    if  (this.isCSVFile(this.ext)) {

      let  reader:  FileReader  =  new  FileReader();
      reader.readAsText(this.link);
      reader.onload  =  (data)  =>  {
        let  csvData :  string  =  reader.result;
        let  csvRecordsArray  =  csvData.split(/\r|\n|\n/);
        let  headersRow  =  this.getHeaderArray(csvRecordsArray);

        this.userDetails  =  this.getDataRecordsArrayFromCSVFile(csvRecordsArray,  headersRow.length);
      }
    }

    else {
      alert("please enter a csv file");
    }

  }

  getDataRecordsArrayFromCSVFile(csvRecordsArray: any, headerLength: any) {

    for (let i = 1; i < csvRecordsArray.length; i++) {
      let data = csvRecordsArray[i].split(',');
      if (data.length == headerLength) {
        var dataArr = [];
        for (let j = 0; j < headerLength; j++) {
          dataArr.push(data[j]);
        }

        this.lines.push(dataArr);
      }

    }

    return null;
  }

  getHeaderArray(csvRecordsArr: any) {
    let headers = csvRecordsArr[0].split(',');
    let headerArray = [];
    for (let j = 0; j < headers.length; j++) {
      headerArray.push(headers[j]);
    }
    return headerArray;
  }

  isCSVFile(extn: string) {
    this.extCheck = (extn === this.extation);
    return this.extCheck;
  }

  importData() {

    for (var i = 0; i < this.lines.length; i++) {

      this.userDetail.userName = this.lines[i][0];
      this.userDetail.firstName = this.lines[i][1];
      this.userDetail.lastName = this.lines[i][2];
      this.userDetail.company = this.lines[i][3];
      this.userDetail.password = 'Cg@123';
      this.userDetail.ipAddress = this.ipAddress;
      this.userDetail.clientName = localStorage.getItem('clientName');
      this.userDetail.createdBy = localStorage.getItem('clientName');
      this.userDetail.createdDateTime = new Date();
      this.userDetail.isAdmin = this.lines[i][4];
      this.userDetail.isDeactivate = false;
      this.userDetail.isDeleted = 0;
      this.userDetail.lastLogin = 0;
      this.userDetail.modifiedBy = localStorage.getItem('clientName');
      this.userDetail.modifiedDateTime = new Date();
      this.userservice.addUser(this.userDetail)
        .subscribe();
      this.router.navigate(['/user']);
    }

  }

  cancel() {
    this.router.navigate(['/user']);
  }

  ngOnInit() {
    this.userservice.users.subscribe(data  =>  { this.ipAddress =  data; });
  }

}
