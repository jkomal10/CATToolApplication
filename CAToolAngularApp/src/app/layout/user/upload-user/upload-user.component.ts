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

  filename : any;
  link : any;
  ext : string ;
  extCheck : boolean =  false;
  extation : string = ".csv";
  userDetails : Users = new Users();
  userDetail : Users = new Users();
  lines = [];
  ipAddress : any;
  constructor(private userservice : UsersService,public router: Router) { }

  fileChangeListener(event:any){
    this.filename = event.target.files[0].name;
    this.link = event.target.files[0];
    console.log("link"+this.link);
    this.ext = this.filename.substring(this.filename.lastIndexOf('.')).toLowerCase();
    console.log(this.ext);

    if (this.isCSVFile(this.ext)){
      console.log(this.filename);
      console.log("csv file");
      let reader: FileReader = new FileReader();
        reader.readAsText(this.link);
        reader.onload = (data) => {
          let csvData : string = reader.result;
          let csvRecordsArray = csvData.split(/\r|\n|\n/);
          // console.log(csvRecordsArray);
           let headersRow = this.getHeaderArray(csvRecordsArray);
           console.log(headersRow);

             this.userDetails =  this.getDataRecordsArrayFromCSVFile(csvRecordsArray, headersRow.length);
            
        }
    }

    else{
      alert("please enter a csv file");
    }
        console.log(this.filename[0]+"___________");
        console.log(this.link+"**************");
  }

  getDataRecordsArrayFromCSVFile(csvRecordsArray : any,headerLength : any){

    for (let i = 1; i < csvRecordsArray.length; i++) {
      let data = csvRecordsArray[i].split(',');
      if (data.length == headerLength) {
        console.log("headerLength"+headerLength)
        console.log("data.length"+data.length);
        // var userDetail : Users = new Users();
        var dataArr = [];
        for (let j = 0; j < headerLength; j++) {
          dataArr.push(data[j]);
      }

     
        // this.userDetail.userName = data[0].trim();
        // this.userDetail.firstName = data[1].trim();
        // this.userDetail.lastName = data[1].trim();
        // this.userDetail.company = data[1].trim();

        // dataArr.push(this.userDetail);
        
         this.lines.push(dataArr);
      }
      console.log("dataArr------------"+dataArr);
      // console.log(this.userDetail);
      
        console.log(">>>>>>>>>>>>>>>>>this.lines", this.lines);
      

    }
    console.log(this.lines.length);
    for (var i = 0; i < this.lines.length; i++)
      {
        
      console.log("adduser of row"+this.lines[i][0]);
      }
    return null;
  }

  getHeaderArray(csvRecordsArr : any){
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

  importData(){

    for (var i = 0; i < this.lines.length; i++)
    {
   
      this.userDetail.userName = this.lines[i][0];
      this.userDetail.firstName =this.lines[i][1];
      this.userDetail.lastName =this.lines[i][2];
      this.userDetail.company = this.lines[i][3];
      this.userDetail.ipAddress = this.ipAddress;
      console.log("this.lines[i][0]"+this.lines[i][0]);
      console.log("this.lines[i][1]"+this.lines[i][1]);
      console.log("this.lines[i][2]"+this.lines[i][2]);
      console.log("this.lines[i][3]"+this.lines[i][3]);
      console.log("this.userDetail.ipAddress"+this.ipAddress)
      this.userservice.addUser(this.userDetail)
    .subscribe();
    console.log("success");
    this.router.navigate(['/user']);
    console.log("----------this.userDetail"+this.userDetail);
    }
    console.log("this.userDetail"+this.userDetail);
    console.log("ipAddress ------"+this.ipAddress)
   }

  cancel(){
    this.router.navigate(['/user']);
  }

  ngOnInit() {
    this.userservice.users.subscribe(data => {this.ipAddress= data;}); 
  }

}
