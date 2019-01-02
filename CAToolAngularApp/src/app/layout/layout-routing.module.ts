import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';


const routes: Routes = [
    {
        path: '',
        component: LayoutComponent,
        children: [
            { path: '', redirectTo: 'dashboard', pathMatch: 'prefix' },
            { path: 'dashboard', loadChildren: './dashboard/dashboard.module#DashboardModule' },    
            { path: 'user', loadChildren: './user/user.module#UserModule' },
            { path: 'application', loadChildren: './application/application.module#ApplicationModule' },
            { path: 'assessment-questions', loadChildren: './assessment-questions/assessment-questions.module#AssessmentQuestionsModule' },
            { path: 'report', loadChildren: './report/report.module#ReportModule' },
            { path: 'for-cloud-provider', loadChildren: './decision-tree/for-cloud-provider/for-cloud-provider.module#ForCloudProviderModule' },
            { path: 'for-cloudable', loadChildren: './decision-tree/for-cloudable/for-cloudable.module#ForCloudableModule' },
            { path: 'for-migration-pattern', loadChildren: './decision-tree/for-migration-pattern/for-migration-pattern.module#ForMigrationPatternModule' },
            { path: 'reassessment', loadChildren: './decision-tree/reassessment/reassessment.module#ReassessmentModule' },
            { path: 'feedback', loadChildren: './feedback/feedback.module#FeedbackModule'},
            { path: 'help', loadChildren: './help/help.module#HelpModule'},
            { path: 'faq', loadChildren: './faq/faq.module#FaqModule'}
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class LayoutRoutingModule {}
