import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ImportQuestionsRoutingModule } from './import-questions-routing.module';
import { ImportQuestionsComponent } from './import-questions.component';

@NgModule({
    imports: [CommonModule, ImportQuestionsRoutingModule],
    declarations: [ImportQuestionsComponent]
})
export class ImportQuestionsModule {}

