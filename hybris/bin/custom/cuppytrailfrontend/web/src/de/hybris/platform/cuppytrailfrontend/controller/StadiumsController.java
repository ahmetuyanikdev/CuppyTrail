package de.hybris.platform.cuppytrailfrontend.controller;

import de.hybris.platform.cuppytrail.data.StadiumData;
import de.hybris.platform.cuppytrail.facades.StadiumFacade;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StadiumsController {
    final static Logger logger = Logger.getLogger(StadiumsController.class);

    private StadiumFacade stadiumFacade;

    @RequestMapping(value = "/stadiums")
    public String showStadiums(final Model model) {
        logger.info("Querying all Stadiums");
        final List<StadiumData> stadiums = stadiumFacade.getStadiums("stadiumListFormat");
        model.addAttribute("stadiums", stadiums);
        return "StadiumListing";
    }

    @RequestMapping(value = "/stadiums/{stadiumName}")
    public String showStadiumDetails(@PathVariable String stadiumName, final Model model) throws UnsupportedEncodingException {
        logger.info("#--Querying Stadium for detail");
        stadiumName = URLDecoder.decode(stadiumName, "UTF-8");
        final StadiumData stadium = stadiumFacade.getStadium(stadiumName, "stadiumDetailsFormat");
        stadium.setName(stadium.getName());//StadiumsNameEncoded.getNameEncoded(stadium.getName()));
        model.addAttribute("stadium", stadium);
        return "StadiumDetails";
    }

    @RequestMapping(value = "/stadiums/type/{stadiumType}")
    public String showStadiumsByType(@PathVariable final String stadiumType, final Model model) {
        logger.info("#--Quering for stadiums by  type");
        final List<StadiumData> stadiums = stadiumFacade.getStadiumsByType(stadiumType, "stadiumDetailsFormat");
        model.addAttribute("stadiums", stadiums);
        return "StadiumListing";
    }

    @Autowired
    public void setFacade(final StadiumFacade facade) {
        this.stadiumFacade = facade;
    }
}
