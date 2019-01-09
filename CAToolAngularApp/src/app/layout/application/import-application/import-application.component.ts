import { Component, OnInit } from '@angular/core';
import { ApplicationService } from '../application.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Application } from '../Application';
import { UsersService } from '../../user/user.service';
import { LocalStorageService } from '../../utility/service/localStorage.service';

@Component({
  selector: 'app-import-application',
  templateUrl: './import-application.component.html',
  styleUrls: ['./import-application.component.scss']
})
export class ImportApplicationComponent implements OnInit {
  filename: any;
  link: any;
  ext: string;
  extCheck: boolean = false;
  extation: string = ".csv";
  applications: Application = new Application();
  application: Application = new Application();
  lines = [];
  value: any = [];
  userData: any = [];
  ipAddress: any;
  existingUser: number;
  clientName: string = localStorage.getItem('clientName');
  constructor(private myStorage: LocalStorageService, public router: Router, private applicationService: ApplicationService, private userService: UsersService) { }

  ngOnInit() {
  }
  fileChangeListener(event: any) {
    this.filename = event.target.files[0].name;
    this.link = event.target.files[0];
    this.ext = this.filename.substring(this.filename.lastIndexOf('.')).toLowerCase();

    if (this.isCSVFile(this.ext)) {
      let reader: FileReader = new FileReader();
      reader.readAsText(this.link);
      reader.onload = (data) => {
        let csvData: string = reader.result;
        let csvRecordsArray = csvData.split(/\r|\n|\n/);
        let headersRow = this.getHeaderArray(csvRecordsArray);
        this.applications = this.getDataRecordsArrayFromCSVFile(csvRecordsArray, headersRow.length);

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
      var userName = this.lines[i][2];
      this.getuserIdByName(userName);
      this.router.navigate(['/application']);
      console.log(this.value);

    }
  }

  getuserIdByName(userName) {
    this.userService.getUserByUserName(this.myStorage.getCurrentUserObject().clientId, userName).subscribe(data => {
      this.value = data, console.log(this.value)


      for (var i = 0; i < 1; i++) {


        this.application.applicationName = this.lines[i][0];
        this.application.applicationDescription = this.lines[i][1];
        this.application.clientId = this.myStorage.getCurrentUserObject().clientId;
        this.application.cloudProvider = "";
        this.application.createdBy = this.myStorage.getCurrentUserObject().userName;
        this.application.createdDate = new Date();
        this.application.isAssessment = false;
        this.application.isDeactivate = false;
        this.application.isDeleted = false;
        this.application.isFinalize = 0;
        this.application.isSaved = 0;
        this.application.isVerified = false;
        this.application.MigrationPattern = "";
        this.application.modifiedBy = localStorage.getItem('clientName');
        this.application.modifiedDateTime = new Date();
        this.existingUser = this.value.id;
        this.application.userId = this.existingUser;
        this.application.clientId = this.myStorage.getCurrentUserObject().clientId;
        this.applicationService.createApplication(this.application)
          .subscribe();
      }


    });
    return 0;
  }



}
