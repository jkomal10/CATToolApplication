import { ImportApplicationRoutingModule } from './import-application-routing.module';

describe('ImportApplicationRoutingModule', () => {
  let importApplicationRoutingModule: ImportApplicationRoutingModule;

  beforeEach(() => {
    importApplicationRoutingModule = new ImportApplicationRoutingModule();
  });

  it('should create an instance', () => {
    expect(importApplicationRoutingModule).toBeTruthy();
  });
});
