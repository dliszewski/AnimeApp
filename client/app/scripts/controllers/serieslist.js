'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:SerieslistCtrl
 * @description
 * # SerieslistCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('SerieslistCtrl', ['EpisodesFactory','$scope','SeriesFactory', function (EpisodesFactory,$scope,SeriesFactory) {
    SeriesFactory.query(function(data){
      $scope.series = data;
    });

      EpisodesFactory.getlatest(10).success(function (data){
        $scope.episodes = data;
      });

    $scope.startsWith = function (actual,exp) {
      var lowerStr = (actual + '').toLowerCase();
      return lowerStr.indexOf( exp.toLowerCase()) === 0;
    };

  }]);
