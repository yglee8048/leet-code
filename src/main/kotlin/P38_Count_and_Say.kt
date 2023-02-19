class P38_Count_and_Say {

    fun countAndSay(n: Int): String {
        if (n == 1) {
            return "1"
        }
        return convert(countAndSay(n - 1))
    }

    private fun convert(say: String): String {
        val queue = mutableListOf<Counter>()    // 리스트를 양방향 큐처럼 사용

        // 순회하며 양방향 큐를 규칙에 따라 채운다.
        for (c in say) {
            val now = Character.getNumericValue(c)
            // 큐가 비어있거나 last != now 라면 큐에 now(1)를 넣는다.
            if (queue.isEmpty() || queue.last().num != now) {
                queue.add(Counter(now, 1))
            } else {    // last == now 라면 last 의 count 를 추가한다.
                queue.last().count++
            }
        }

        return queue.asSequence()
            .map { counter -> counter.toString() }
            .fold("") { ans, nxt -> ans + nxt } // 문자열을 이어붙인다.
    }

    class Counter(
        val num: Int,
        var count: Int
    ) {
        override fun toString(): String {
            return this.count.toString() + this.num.toString()
        }
    }
}