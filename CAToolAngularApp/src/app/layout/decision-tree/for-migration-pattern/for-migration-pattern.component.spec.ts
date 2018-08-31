import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForMigrationPatternComponent } from './for-migration-pattern.component';

describe('ForMigrationPatternComponent', () => {
  let component: ForMigrationPatternComponent;
  let fixture: ComponentFixture<ForMigrationPatternComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForMigrationPatternComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForMigrationPatternComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
