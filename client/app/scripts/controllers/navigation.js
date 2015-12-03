'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:NavigationCtrl
 * @description
 * # NavigationCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('NavigationCtrl',['$scope', '$location', function($scope, $location) {
      $scope.$location = $location;
    }]);