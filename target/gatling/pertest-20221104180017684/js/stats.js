var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "7",
        "ok": "7",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "649",
        "ok": "649",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1572",
        "ok": "1572",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "978",
        "ok": "978",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "300",
        "ok": "300",
        "ko": "-"
    },
    "percentiles1": {
        "total": "887",
        "ok": "887",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1105",
        "ok": "1105",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1460",
        "ok": "1460",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1550",
        "ok": "1550",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 2,
    "percentage": 29
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 4,
    "percentage": 57
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1,
    "percentage": 14
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.583",
        "ok": "0.583",
        "ko": "-"
    }
},
contents: {
"req_post--api-users-7a661": {
        type: "REQUEST",
        name: "POST /api/users/login",
path: "POST /api/users/login",
pathFormatted: "req_post--api-users-7a661",
stats: {
    "name": "POST /api/users/login",
    "numberOfRequests": {
        "total": "1",
        "ok": "1",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1012",
        "ok": "1012",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1012",
        "ok": "1012",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1012",
        "ok": "1012",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1012",
        "ok": "1012",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1012",
        "ok": "1012",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1012",
        "ok": "1012",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1012",
        "ok": "1012",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 100
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.083",
        "ok": "0.083",
        "ko": "-"
    }
}
    },"req_post--api-artic-043e6": {
        type: "REQUEST",
        name: "POST /api/articles",
path: "POST /api/articles",
pathFormatted: "req_post--api-artic-043e6",
stats: {
    "name": "POST /api/articles",
    "numberOfRequests": {
        "total": "6",
        "ok": "6",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "649",
        "ok": "649",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1572",
        "ok": "1572",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "973",
        "ok": "973",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "324",
        "ok": "324",
        "ko": "-"
    },
    "percentiles1": {
        "total": "878",
        "ok": "878",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1120",
        "ok": "1120",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1479",
        "ok": "1479",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1553",
        "ok": "1553",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 2,
    "percentage": 33
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 3,
    "percentage": 50
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1,
    "percentage": 17
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.5",
        "ok": "0.5",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
