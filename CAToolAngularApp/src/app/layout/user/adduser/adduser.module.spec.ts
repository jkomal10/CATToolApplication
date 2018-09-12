import { AdduserModule } from './adduser.module';

describe('AdduserModule', () => {
  let adduserModule: AdduserModule;

  beforeEach(() => {
    adduserModule = new AdduserModule();
  });

  it('should create an instance', () => {
    expect(adduserModule).toBeTruthy();
  });
});
