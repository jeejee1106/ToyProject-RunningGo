<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="container-margin">
        <div class="write-wrap">
            <h4>나만의 러닝 맛집 프로필!</h4>
            <table class="recmnd-table">
                <tr>
                    <th>위치</th>
                    <td>
                        <select>
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
                        <input type="text">
                    </td>
                    <th>가까운 지하철 역</th>
                    <td>
                        <input type="text" id="subway">
                        <button type="button" id="subway-search-btn">검색</button>
                    </td>
                </tr>
                <tr>
                    <th>난이도</th>
                    <td>
                        <button type="button">최상</button>
                        <button type="button">상</button>
                        <button type="button">중</button>
                        <button type="button">하</button>
                        <button type="button">최하</button>
                    </td>
                    <th>짐 보관</th>
                    <td>
                        <input type="radio" name="storage">가능
                        <input type="radio" name="storage">불가능
                    </td>
                </tr>
                <tr>
                    <th>추천 이유</th>
                    <td colspan="3">
                        <textarea class="recmnd-content"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>이미지</th>
                    <td colspan="3">
                        <input type="file">
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>