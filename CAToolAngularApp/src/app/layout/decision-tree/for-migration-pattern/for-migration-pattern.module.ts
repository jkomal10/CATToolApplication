import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule,ReactiveFormsModule} from '@angular/forms';

import { ForMigrationPatternRoutingModule } from './for-migration-pattern-routing.module';
import { ForMigrationPatternComponent } from './for-migration-pattern.component';
import { PublicPassComponent } from './public-pass/public-pass.component';
import { EvaluationOrderComponent } from './evaluation-order/evaluation-order.component';

@NgModule({
    imports: [CommonModule, ForMigrationPatternRoutingModule, FormsModule,ReactiveFormsModule],
    declarations: [ForMigrationPatternComponent, PublicPassComponent, EvaluationOrderComponent]
})

export class ForMigrationPatternModule {}
