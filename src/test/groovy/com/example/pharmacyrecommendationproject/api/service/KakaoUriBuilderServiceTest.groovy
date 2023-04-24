package com.example.pharmacyrecommendationproject.api.service

import org.junit.jupiter.api.DisplayName
import spock.lang.Specification

import java.nio.charset.StandardCharsets

class KakaoUriBuilderServiceTest extends Specification {

    private KakaoUriBuilderService kakaoUriBuilderService;

    def setup() {
        kakaoUriBuilderService = new KakaoUriBuilderService()
    }

    def "buildUriByAddressSearch - 한글 파라미터의 경우 정상적으로 인코딩"() {
        given:
        String address = "서울 성북구"
        def charset = StandardCharsets.UTF_8

        when:
        // TODO implement stimulus
        def uri = kakaoUriBuilderService.buildUriByAddressSearch(address) // def를 이용해서 타입을 선언해줘도되고, String 처럼 명시적으로 타입을 선언해줘도 된다.
        def decodedResult = URLDecoder.decode(uri.toString(), charset)

        then:
        // TODO implement assertions
        decodedResult == "https://dapi.kakao.com/v2/local/search/address.json?query=서울 성북구"
    }
}
