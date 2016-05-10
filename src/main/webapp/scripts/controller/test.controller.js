'use strict';

angular.module('app')
    .controller('TestController', function ($scope, service, $state) {

        var vm = this;
        vm.delete = deleteTest;
        vm.runTest = runTest;
        vm.goToUpdate = goToUpdate;

        function init() {
            service.loadTests().then(function (response) {
                vm.tests = response.data;
            });
        }

        function goToUpdate(testId) {
            $state.go('tests.update', {id: testId});
        }

        function runTest(testId) {
            service.run(testId).then(function () {
                init();
            });
        }

        function deleteTest(testId) {
            service.delete(testId).then(function () {
                init();
            });
        }

        init();

    });