(import '(javax.xml.parsers DocumentBuilderFactory DocumentBuilder)
        '(org.w3c.dom Document Node)
        '(javax.xml.xpath XPathFactory XPath XPathExpression XPathConstants)
  )

(let [domFactory (doto (. DocumentBuilderFactory newInstance) (setNamespaceAware true))
      builder (. domFactory newDocumentBuilder)
      doc (. builder parse "http://wikipedia.org/")
      factory (. XPathFactory newInstance)
      xpath (. factory newXPath)
      expr (. xpath compile "//title/text()")
      result (. expr evaluate doc (. XPathConstants NODESET))
      ]
   (loop [index 0
          len (. result getLength)]
     (if (< index len)
       (do
         (println (. (. result item index) getNodeValue))
         (recur (inc index) len)))
))
