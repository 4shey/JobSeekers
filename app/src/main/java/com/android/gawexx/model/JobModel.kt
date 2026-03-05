package com.android.gawexx.model

data class JobApplyModel (
    val id:Int,
    val applicationDate: String,
    val job: JobModel
)

data class JobModel (
    val id:Int,
    val name: String,
    val company: CompanyModel,
    val locationType: String,
    val locationRegion: String,
    val yearOfExperience: String,
    val quota: Int,
)
data class CompanyModel (
    val name: String,
)