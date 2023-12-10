package com.itrail.mvckot.response

import lombok.*

@Data
@AllArgsConstructor
class BaseResponse (val code: Int, val message: String ) {


}