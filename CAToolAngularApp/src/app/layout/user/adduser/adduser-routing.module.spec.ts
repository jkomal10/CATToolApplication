import { AdduserRoutingModule } from './adduser-routing.module';

describe('AdduserRoutingModule', () => {
  let adduserRoutingModule: AdduserRoutingModule;

  beforeEach(() => {
    adduserRoutingModule = new AdduserRoutingModule();
  });

  it('should create an instance', () => {
    expect(adduserRoutingModule).toBeTruthy();
  });
});
