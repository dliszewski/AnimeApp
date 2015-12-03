'use strict';

/**
 * @ngdoc service
 * @name clientApp.tagsfactory
 * @description
 * # tagsfactory
 * Factory in the clientApp.
 */
angular.module('clientApp')
  .factory('tagsfactory', function () {
      var factory = {};
      factory.getTagsFor = function (id) {
        return $http.get('http://localhost:8080/api/tags/' + id);
      };
  });
