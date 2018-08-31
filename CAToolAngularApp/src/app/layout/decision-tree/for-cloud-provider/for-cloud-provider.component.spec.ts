import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForCloudProviderComponent } from './for-cloud-provider.component';

describe('ForCloudProviderComponent', () => {
  let component: ForCloudProviderComponent;
  let fixture: ComponentFixture<ForCloudProviderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForCloudProviderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForCloudProviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
