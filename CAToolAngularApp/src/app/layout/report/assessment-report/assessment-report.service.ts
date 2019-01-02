import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LocalStorageService } from '../../utility/service/localStorage.service';


@Injectable({
  providedIn: 'root'
})
export class AssessmentReportService {

  constructor(private http: HttpClient, private myStorage:LocalStorageService) { }

  generateReport(genereteAppReport:any)
  {
    return this.http.get(this.myStorage.getreportURL()+`/assessment/report/generateReport/`+genereteAppReport);

  }

  viewReportInBrowser(appName:any)
  {
    const httpOptions = {
      'responseType'  : 'arraybuffer' as 'json'
       //'responseType'  : 'blob' as 'json'        //This also worked
    };
    return this.http.get(this.myStorage.getreportURL()+`/assessment/report/viewReportInBrowser/`+appName,httpOptions);
  }

  viewGeneratedReport(fromDate,toDate)
  {
     return this.http.get(this.myStorage.getreportURL()+`/assessment/report/viewReport/`+fromDate+`/`+toDate);
  }

  zipExport(fromDate,toDate)
  {
    return this.http.get(this.myStorage.getreportURL()+`/assessment/report/zipExport/`+fromDate+`/`+toDate);
  }
}
