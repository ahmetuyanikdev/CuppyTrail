import de.hybris.platform.servicelayer.search.FlexibleSearchQuery

query = new FlexibleSearchQuery("SELECT {PK} FROM {Stadium} WHERE {code} LIKE ?stadiumCode")
query.addQueryParameter("stadiumCode", stadiumCode);
def resultList = flexibleSearchService.search(query).result

if(resultList.size() == 1) {
	resultList[0]
} else {
	null
}