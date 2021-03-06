package net.codesanctum.ndic


import js.externals.axios.Axios
import net.codesanctum.ndic.parser.ResultHtmlParser
import net.codesanctum.ndic.vo.Word
import kotlin.js.Promise

class NDic {
    companion object {
        private val resultHtmlParser: ResultHtmlParser = ResultHtmlParser.create()

        fun search(query: String): Promise<List<Word>> {
            val request = Axios.get<String>("http://endic.naver.com/searchAssistDict.nhn?query=$query")
            return Promise.resolve(request)
                    .then {
                        resultHtmlParser.parseHtmlToData(it.data)
                    }
        }
    }
}

