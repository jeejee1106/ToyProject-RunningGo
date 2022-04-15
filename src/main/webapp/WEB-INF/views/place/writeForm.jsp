<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="container-margin">
        <div class="write-wrap">
            <div class="write-title">
                <h3>러닝 스팟 추천</h3>
            </div>
            <hr>
            <div class="write-box">
                <h4 class="write-sub-title">스팟 프로필</h4>
                <span class="important imp-tit">*필수입력 사항</span>
                <div class="write-table-box">
                    <form action="/place/recmnd" method="post">
                        <input type="hidden" name="id" value="${sessionScope.id}">
                        <table>
                            <colgroup>
                                <col width="250px;">
                                <col width="550px;">
                            </colgroup>
                            <tbody>
                                <tr>
                                    <th class="top-th">
                                        <span class="important">*</span>위치
                                    </th>
                                    <td class="top-td">
                                        <select name="local1">
                                            <option value="강남구">강남구</option>
                                            <option value="강동구">강동구</option>
                                            <option value="강북구">강북구</option>
                                            <option value="강서구">강서구</option>
                                            <option value="관악구">관악구</option>
                                            <option value="광진구">광진구</option>
                                            <option value="구로구">구로구</option>
                                            <option value="금천구">금천구</option>
                                            <option value="노원구">노원구</option>
                                            <option value="도봉구">도봉구</option>
                                            <option value="동대문구">동대문구</option>
                                            <option value="동작구">동작구</option>
                                            <option value="마포구">마포구</option>
                                            <option value="서대문구">서대문구</option>
                                            <option value="서초구">서초구</option>
                                            <option value="성동구">성동구</option>
                                            <option value="성북구">성북구</option>
                                            <option value="송파구">송파구</option>
                                            <option value="양천구">양천구</option>
                                            <option value="영등포구">영등포구</option>
                                            <option value="용산구">용산구</option>
                                            <option value="은평구">은평구</option>
                                            <option value="종로구">종로구</option>
                                            <option value="중구">중구</option>
                                            <option value="중랑구">중랑구</option>
                                        </select>
                                        <input type="text" name="local2" placeholder="ex)보라매 공원, 삼청동 카페 거리, 잠수교">
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        <span class="important">*</span>인근 지하철 역
                                    </th>
                                    <td>
                                        <input type="text" id="subway" name="subway" placeholder="ex) 보라매, 종합운동장, 동작">
                                        <button type="button" id="subway-search-btn">검색</button>
                                        <div id="lineNum-list"></div>
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        <span class="important">*</span>코스 난이도
                                    </th>
                                    <td>
                                        <input type="hidden" id="level-val" name="level" value="">
                                        <button type="button" class="btn-level" value="최상">최상</button>
                                        <button type="button" class="btn-level" value="상">상</button>
                                        <button type="button" class="btn-level" value="중">중</button>
                                        <button type="button" class="btn-level" value="하">하</button>
                                        <button type="button" class="btn-level" value="최하">최하</button>
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        <span class="important">*</span>짐 보관
                                    </th>
                                    <td>
                                        <div>
                                            <label id="write-label1"><input id="write-radio1" type="radio" name="storage-YN" value="Y">가능</label>
                                            <label id="write-label2"><input id="write-radio2" type="radio" name="storage-YN" value="N">불가능</label>
                                        </div>
                                        <div class="storage-place">
                                            짐 보관 장소 : <input type="text" name="storage" placeholder="ex) ○○역 물품보관함, ○○스토어 무료 짐 보관">
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        <span class="important">*</span>예상 거리
                                    </th>
                                    <td>
                                        <input type="text" name="distance" id="distance">km
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        <span class="important">*</span>코스 설명
                                    </th>
                                    <td>
                                        <textarea class="recmnd-content" name="description" placeholder="최대한 구체적으로 적어주세요!&#13;&#10;ex) 보라매공원에 도착하면 공원 여기저기를 달릴 수 있어요! 공원 안에 있는 트랙 한 바퀴가 ○○m 정도 되기 때문에 거리를 정해놓고 러닝하기에 딱입니다!"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        <span class="important">*</span>추천 이유
                                    </th>
                                    <td>
                                        <textarea class="recmnd-content" name="reason" placeholder="이 스팟을 추천하는 이유?! 나만의 꿀팁도 공유하는 센스!&#13;&#10;ex) 보라매역 3번출구나 신대방역 4번출구로 나오시면 쉽게 찾을 수 있어요! 장, 단거리 트랙도 나누어져 있고, 초보자도 뛰기에 무리 없는 평지 코스입니다. 러닝 후에 트랙 옆 편의점에서 공원라면을 즐길 수 있습니다!"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        <span class="important">*</span>이미지
                                    </th>
                                    <td>
                                        <input type="file">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="write-btn-box">
                            <button type="button">취소</button>
                            <button type="submit" class="btn-recmnd">등록</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>