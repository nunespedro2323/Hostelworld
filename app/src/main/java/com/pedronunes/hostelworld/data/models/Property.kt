package com.pedronunes.hostelworld.data.models

import android.text.Html
import com.google.gson.annotations.SerializedName
import java.util.*


data class Property(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("isPromoted") var isPromoted: Boolean? = null,
    @SerializedName("hbid") var hbid: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("starRating") var starRating: Int? = null,
    @SerializedName("overallRating") var overallRating: OverallRating? = OverallRating(),
    @SerializedName("ratingBreakdown") var ratingBreakdown: RatingBreakdown? = RatingBreakdown(),
    @SerializedName("latitude") var latitude: Double? = null,
    @SerializedName("longitude") var longitude: Double? = null,
    @SerializedName("isFeatured") var isFeatured: Boolean? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("address1") var address1: String? = null,
    @SerializedName("address2") var address2: String? = null,
    @SerializedName("freeCancellationAvailable") var freeCancellationAvailable: Boolean? = null,
    @SerializedName("freeCancellationAvailableUntil") var freeCancellationAvailableUntil: String? = null,
    @SerializedName("district") var district: District? = District(),
    @SerializedName("districts") var districts: ArrayList<Districts> = arrayListOf(),
    @SerializedName("freeCancellation") var freeCancellation: FreeCancellation? = FreeCancellation(),
    @SerializedName("lowestPricePerNight") var lowestPricePerNight: Price? = Price(),
    @SerializedName("lowestPrivatePricePerNight") var lowestPrivatePricePerNight: Price? = Price(),
    @SerializedName("lowestDormPricePerNight") var lowestDormPricePerNight: Price? = Price(),
    @SerializedName("lowestAveragePricePerNight") var lowestAveragePricePerNight: PriceWithPromotions? = PriceWithPromotions(),
    @SerializedName("lowestAverageDormPricePerNight") var lowestAverageDormPricePerNight: PriceWithPromotions? = PriceWithPromotions(),
    @SerializedName("lowestAveragePrivatePricePerNight") var lowestAveragePrivatePricePerNight: PriceWithPromotions? = PriceWithPromotions(),
    @SerializedName("isNew") var isNew: Boolean? = null,
    @SerializedName("overview") var overview: String? = null,
    @SerializedName("isElevate") var isElevate: Boolean? = null,
    @SerializedName("hostelworldRecommends") var hostelworldRecommends: Boolean? = null,
    @SerializedName("distance") var distance: Distance? = Distance(),
    @SerializedName("position") var position: Int? = null,
    @SerializedName("hwExtra") var hwExtra: String? = null,
    @SerializedName("fabSort") var fabSort: FabSort? = FabSort(),
    @SerializedName("promotions") var promotions: ArrayList<Promotions> = arrayListOf(),
    @SerializedName("rateRuleViolations") var rateRuleViolations: ArrayList<RateRuleViolations> = arrayListOf(),
    @SerializedName("stayRuleViolations") var stayRuleViolations: ArrayList<StayRuleViolations> = arrayListOf(),
    @SerializedName("originalLowestAveragePricePerNight") var originalLowestAveragePricePerNight: Price? = Price(),
    @SerializedName("originalLowestAverageDormPricePerNight") var originalLowestAverageDormPricePerNight: Price? = Price(),
    @SerializedName("originalLowestAveragePrivatePricePerNight") var originalLowestAveragePrivatePricePerNight: Price? = Price(),
    @SerializedName("fenceDiscount") var fenceDiscount: Int? = null,
    @SerializedName("veryPopular") var veryPopular: Boolean? = null,
    @SerializedName("images") var images: ArrayList<Images> = arrayListOf(),
    @SerializedName("imagesGallery") var imagesGallery: ArrayList<Images> = arrayListOf(),
    @SerializedName("facilities") var facilities: ArrayList<Facilities> = arrayListOf()

) {
    fun getTypeLowercaseCapitalize() = type?.lowercase()
        ?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }

    fun getOverviewDecoded() = Html.fromHtml(overview, Html.FROM_HTML_MODE_LEGACY).toString()
}