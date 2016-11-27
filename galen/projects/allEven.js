

this.allEven = function (pattern) {
    var size = count(pattern);
    var ima = new HTMLImageElement;
    var parameters = "2";
    if (size > 1) {
        for (var i = 4; i <= size; i+=2) {
            parameters = parameters + "," + i;
        }
    }

    return parameters;
};