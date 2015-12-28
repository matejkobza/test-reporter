'use strict';

angular.module('app')
    .controller('TestController', function ($scope, service) {
        // tu je controller pre tabulku v zakladnom view
        var vm = this;


        service.loadTests().then(function (response) {
            vm.tests = response.data;
        });

    });