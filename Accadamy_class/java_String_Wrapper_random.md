# String
- 문자열의 추출, 비교, 찾기, 분리, 변환 등 다양한 메소드를 가지는 사용빈도가 높은 메소드

# Wrapper(포장 객체)
- 기본 타입(Byte, char, short, int, long, float, double, boolean) 값을 내부에 두고 포장하는 객체
- 기본 타입의 값은 외부에서 변경 불가

## Boxing
- 기본 타입의 값을 포장객체로 만드는 과정

#### 박싱하는 방법 : 생성자 이용
<table border ="1" >
    <tr>
        <th>기본 타입의 값을 줄 경우</th>
        <th>문자 열을 줄 경우</th>
    </tr>
    <tr>
        <td>Byte obj = new Byte(10);</td>
        <td>Byte obj = new Byte("10");</td>
    </tr>
    <tr>
        <td>Character obj = new Character('가');</td>
        <td></td>
    </tr>
    <tr>
        <td>Short obj = new Short(100);</td>
        <td>Short obj = new Short("100");</td>
    </tr>
    <tr>
        <td>Interger obj = new Integer(1000);</td>
        <td>Interger obj - new Integer("1000");</td>
    </tr>
    <tr>
        <td>Long obj - new Long(10000);</td>
        <td>Long obj = new Long("10000");</td>
    </tr>
    <tr>
        <td>Float obj = new Float(2.5F);</td>
        <td>Float obj = new Float("2.5F");</td>
    </tr>
    <tr>
        <td>Double obj = new Double(3.5);</td>
        <td>Double obj = new Double("3.5");</td>
    </tr>
    <tr>
        <td>Boolean obj = new Boolean(true);</td>
        <td>Boolean obj = new Boolean("true");</td>
    </tr>
</table>

#### valueOf() method 이용
- Integer obj = Integer.valueOf(1000);
- Integer obj = Integer.valueOf("1000");

# Random