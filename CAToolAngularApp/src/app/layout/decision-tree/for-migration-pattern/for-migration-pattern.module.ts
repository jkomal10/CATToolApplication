import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule,ReactiveFormsModule} from '@angular/forms';
import { DataTablesModule } from 'angular-datatables';
import { ForMigrationPatternRoutingModule } from './for-migration-pattern-routing.module';
import { ForMigrationPatternComponent } from './for-migration-pattern.component';
import { EvaluationOrderComponent } from './evaluation-order/evaluation-order.component';
import { MigrationPatternsComponent } from './migration-patterns/migration-patterns.component';

@NgModule({
    imports: [CommonModule, ForMigrationPatternRoutingModule, FormsModule,ReactiveFormsModule,DataTablesModule],
    declarations: [ForMigrationPatternComponent, EvaluationOrderComponent, MigrationPatternsComponent]
})

export class ForMigrationPatternModule {}
