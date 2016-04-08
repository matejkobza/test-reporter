'use strict';

angular.module('app')
    .controller('NewTestController', function ($scope, service, $state) {

        var vm = this;
        $scope.onlyNumbers = /^[0-9]+$/;

        vm.test = {
            akt: undefined,
            group: undefined,
            code: undefined,
            name: undefined,
            sourceSql: undefined,
            targetSql: undefined,
            oond_sql: undefined,
            description: undefined,
            src_par: undefined,
            trg_par: undefined
        };

        vm.dataSources = undefined;

        vm.send = send;
        vm.init = init;

        /**
         * if valid then send data and store them
         */
        function send() {
            if (validate()) {
                service.save(vm.test).then(function (response) {
                    $state.go('tests');
                });
            } else {
                alert("Prosím, opravte zle zadané hodnoty!");
            }
        }

        function validate() {
            return vm.test.akt.length && vm.test.name.length;
        }

        function init() {
            service.loadSettings().then(function (response) {
                vm.dataSources = response.data;

            });
        }

        init();

    });