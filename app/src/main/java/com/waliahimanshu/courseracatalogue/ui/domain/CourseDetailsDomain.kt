package com.waliahimanshu.courseracatalogue.ui.domain

class CourseDetailsDomain(val id: String,
                          val courseType: String,
                          val name: String,
                          val slug: String,
                          var photoUrl: String,
                          val partnerName: List<InfoDomain>,
                          val instructorName: List<InfoDomain>)
