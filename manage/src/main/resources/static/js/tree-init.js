var TreeView = function () {

    return {
        //main function to initiate the module
        init: function () {

            var DataSourceTree = function (options) {
                this._data  = options.data;
                this._delay = options.delay;
            };

            DataSourceTree.prototype = {

                data: function (options, callback) {
                    var self = this;

                    setTimeout(function () {
                        var data = $.extend(true, [], self._data);

                        callback({ data: data });

                    }, this._delay)
                }
            };

            // INITIALIZING TREE
            var treeDataSource = new DataSourceTree({
                data: [
                    { name: '企业概况', type: 'folder', additionalParameters: { id: 'F1' } },
                    { name: '新闻中心', type: 'folder', additionalParameters: { id: 'F2' } },
                    { name: 'View Category', type: 'item', additionalParameters: { id: 'I1' } },
                    { name: 'Testing', type: 'item', additionalParameters: { id: 'I2' } }
                ],
                delay: 100
            });

            $('#FlatTree').tree({
                dataSource: treeDataSource,
                loadingHTML: '<img src="images/input-spinner.gif"/>',
            });

        }

    };

}();



