'use strict';

describe('Service: tagsfactory', function () {

  // load the service's module
  beforeEach(module('clientApp'));

  // instantiate service
  var tagsfactory;
  beforeEach(inject(function (_tagsfactory_) {
    tagsfactory = _tagsfactory_;
  }));

  it('should do something', function () {
    expect(!!tagsfactory).toBe(true);
  });

});
